package com.smat.core.controleacesso.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
public class LoginResponse {

  private @Nullable String token;

  private @Nullable Usuario usuario;

  private @Nullable Integer expiresIn;

  @Valid
  private List<@Valid MenuItem> menu;

  public LoginResponse token(@Nullable String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   */
  
  @Schema(name = "token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("token")
  public @Nullable String getToken() {
    return token;
  }

  @JsonProperty("token")
  public void setToken(@Nullable String token) {
    this.token = token;
  }

  public LoginResponse usuario(@Nullable Usuario usuario) {
    this.usuario = usuario;
    return this;
  }

  /**
   * Get usuario
   * @return usuario
   */
  @Valid 
  @Schema(name = "usuario", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("usuario")
  public @Nullable Usuario getUsuario() {
    return usuario;
  }

  @JsonProperty("usuario")
  public void setUsuario(@Nullable Usuario usuario) {
    this.usuario = usuario;
  }

  public LoginResponse expiresIn(@Nullable Integer expiresIn) {
    this.expiresIn = expiresIn;
    return this;
  }

  /**
   * Get expiresIn
   * @return expiresIn
   */
  
  @Schema(name = "expiresIn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expiresIn")
  public @Nullable Integer getExpiresIn() {
    return expiresIn;
  }

  @JsonProperty("expiresIn")
  public void setExpiresIn(@Nullable Integer expiresIn) {
    this.expiresIn = expiresIn;
  }

  public LoginResponse menu(List<@Valid MenuItem> menu) {
    this.menu = menu;
    return this;
  }

  public LoginResponse addMenuItem(MenuItem menuItem) {
    if (this.menu == null) {
      this.menu = new ArrayList<>();
    }
    this.menu.add(menuItem);
    return this;
  }

  /**
   * Get menu
   * @return menu
   */
  @Valid 
  @Schema(name = "menu", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("menu")
  public List<@Valid MenuItem> getMenu() {
    return menu;
  }

  @JsonProperty("menu")
  public void setMenu(List<@Valid MenuItem> menu) {
    this.menu = menu;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginResponse loginResponse = (LoginResponse) o;
    return Objects.equals(this.token, loginResponse.token) &&
        Objects.equals(this.usuario, loginResponse.usuario) &&
        Objects.equals(this.expiresIn, loginResponse.expiresIn) &&
        Objects.equals(this.menu, loginResponse.menu);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, usuario, expiresIn, menu);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginResponse {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    usuario: ").append(toIndentedString(usuario)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    menu: ").append(toIndentedString(menu)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(@Nullable Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

