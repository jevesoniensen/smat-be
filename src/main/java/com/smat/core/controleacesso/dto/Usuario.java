package com.smat.core.controleacesso.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;
import java.util.Objects;


@Builder
public class Usuario {

  private @Nullable String id;

  private @Nullable String login;

  private @Nullable String nome;

  private @Nullable String email;

  private @Nullable Boolean ativo;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime dataCadastro;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime ultimoAcesso;

  private @Nullable String agenteSaudeId;

  public Usuario id(@Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(@Nullable String id) {
    this.id = id;
  }

  public Usuario login(@Nullable String login) {
    this.login = login;
    return this;
  }

  /**
   * Get login
   * @return login
   */
  
  @Schema(name = "login", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("login")
  public @Nullable String getLogin() {
    return login;
  }

  @JsonProperty("login")
  public void setLogin(@Nullable String login) {
    this.login = login;
  }

  public Usuario nome(@Nullable String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
   */
  
  @Schema(name = "nome", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nome")
  public @Nullable String getNome() {
    return nome;
  }

  @JsonProperty("nome")
  public void setNome(@Nullable String nome) {
    this.nome = nome;
  }

  public Usuario email(@Nullable String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  
  @Schema(name = "email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public @Nullable String getEmail() {
    return email;
  }

  @JsonProperty("email")
  public void setEmail(@Nullable String email) {
    this.email = email;
  }

  public Usuario ativo(@Nullable Boolean ativo) {
    this.ativo = ativo;
    return this;
  }

  /**
   * Get ativo
   * @return ativo
   */
  
  @Schema(name = "ativo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ativo")
  public @Nullable Boolean getAtivo() {
    return ativo;
  }

  @JsonProperty("ativo")
  public void setAtivo(@Nullable Boolean ativo) {
    this.ativo = ativo;
  }

  public Usuario dataCadastro(@Nullable OffsetDateTime dataCadastro) {
    this.dataCadastro = dataCadastro;
    return this;
  }

  /**
   * Get dataCadastro
   * @return dataCadastro
   */
  @Valid 
  @Schema(name = "dataCadastro", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dataCadastro")
  public @Nullable OffsetDateTime getDataCadastro() {
    return dataCadastro;
  }

  @JsonProperty("dataCadastro")
  public void setDataCadastro(@Nullable OffsetDateTime dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public Usuario ultimoAcesso(@Nullable OffsetDateTime ultimoAcesso) {
    this.ultimoAcesso = ultimoAcesso;
    return this;
  }

  /**
   * Get ultimoAcesso
   * @return ultimoAcesso
   */
  @Valid 
  @Schema(name = "ultimoAcesso", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ultimoAcesso")
  public @Nullable OffsetDateTime getUltimoAcesso() {
    return ultimoAcesso;
  }

  @JsonProperty("ultimoAcesso")
  public void setUltimoAcesso(@Nullable OffsetDateTime ultimoAcesso) {
    this.ultimoAcesso = ultimoAcesso;
  }

  public Usuario agenteSaudeId(@Nullable String agenteSaudeId) {
    this.agenteSaudeId = agenteSaudeId;
    return this;
  }

  /**
   * Get agenteSaudeId
   * @return agenteSaudeId
   */
  
  @Schema(name = "agenteSaudeId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("agenteSaudeId")
  public @Nullable String getAgenteSaudeId() {
    return agenteSaudeId;
  }

  @JsonProperty("agenteSaudeId")
  public void setAgenteSaudeId(@Nullable String agenteSaudeId) {
    this.agenteSaudeId = agenteSaudeId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Usuario usuario = (Usuario) o;
    return Objects.equals(this.id, usuario.id) &&
        Objects.equals(this.login, usuario.login) &&
        Objects.equals(this.nome, usuario.nome) &&
        Objects.equals(this.email, usuario.email) &&
        Objects.equals(this.ativo, usuario.ativo) &&
        Objects.equals(this.dataCadastro, usuario.dataCadastro) &&
        Objects.equals(this.ultimoAcesso, usuario.ultimoAcesso) &&
        Objects.equals(this.agenteSaudeId, usuario.agenteSaudeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, nome, email, ativo, dataCadastro, ultimoAcesso, agenteSaudeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Usuario {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    ativo: ").append(toIndentedString(ativo)).append("\n");
    sb.append("    dataCadastro: ").append(toIndentedString(dataCadastro)).append("\n");
    sb.append("    ultimoAcesso: ").append(toIndentedString(ultimoAcesso)).append("\n");
    sb.append("    agenteSaudeId: ").append(toIndentedString(agenteSaudeId)).append("\n");
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

