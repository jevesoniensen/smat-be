package com.smat.core.controleacesso.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class LoginRequest {

  private String login;

  private String senha;

  public LoginRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LoginRequest(String login, String senha) {
    this.login = login;
    this.senha = senha;
  }

  public LoginRequest login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Get login
   * @return login
   */
  @NotNull 
  @Schema(name = "login", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("login")
  public String getLogin() {
    return login;
  }

  @JsonProperty("login")
  public void setLogin(String login) {
    this.login = login;
  }

  public LoginRequest senha(String senha) {
    this.senha = senha;
    return this;
  }

  /**
   * Get senha
   * @return senha
   */
  @NotNull 
  @Schema(name = "senha", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("senha")
  public String getSenha() {
    return senha;
  }

  @JsonProperty("senha")
  public void setSenha(String senha) {
    this.senha = senha;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginRequest loginRequest = (LoginRequest) o;
    return Objects.equals(this.login, loginRequest.login) &&
        Objects.equals(this.senha, loginRequest.senha);
  }

  @Override
  public int hashCode() {
    return Objects.hash(login, senha);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginRequest {\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    senha: ").append(toIndentedString(senha)).append("\n");
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

