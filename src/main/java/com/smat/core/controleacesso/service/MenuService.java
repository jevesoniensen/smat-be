package com.smat.core.controleacesso.service;

import com.smat.core.controleacesso.dto.MenuItem;
import com.smat.core.controleacesso.repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final ModuloRepository menuRepository;

    public Mono<List<MenuItem>> getMenuForUser(Integer userId) {
        return Mono.fromCallable(() -> menuRepository.listarMenu(userId))
                .subscribeOn(Schedulers.boundedElastic())
                .map(this::convertToTree);
    }

    private List<MenuItem> convertToTree(List<ModuloRepository.MenuResult> results) {
        if (results == null || results.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Integer, MenuItem> menuMap = new HashMap<>();
        List<MenuItem> roots = new ArrayList<>();

        // First pass: create all menu items and identify roots
        for (ModuloRepository.MenuResult res : results) {
            // Skip the dummy root "Menu" (modulo 0) if it shouldn't be in the final UI
            // But usually, it's easier to just take its children as roots
            if (res.getModulo() == 0) continue;

            MenuItem item = MenuItem.builder()
                    .id(String.valueOf(res.getModulo()))
                    .label(res.getNome())
                    .path(res.getNomePaginaDefault() != null ? "/" + res.getNomePaginaDefault().toLowerCase().replace(" ", "-") : null)
                    .order(res.getModulo())
                    .children(new ArrayList<>())
                    .build();

            menuMap.put(res.getModulo(), item);

            if (res.getModuloPai() == null || res.getModuloPai() == 0) {
                roots.add(item);
            }
        }

        // Second pass: build the tree
        for (ModuloRepository.MenuResult res : results) {
            if (res.getModulo() == 0) continue;

            if (res.getModuloPai() != null && res.getModuloPai() != 0) {
                MenuItem parent = menuMap.get(res.getModuloPai());
                MenuItem child = menuMap.get(res.getModulo());
                if (parent != null && child != null) {
                    parent.addChildrenItem(child);
                }
            }
        }

        return roots;
    }
}
