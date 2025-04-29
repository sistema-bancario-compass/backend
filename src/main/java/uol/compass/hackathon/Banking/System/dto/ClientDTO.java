package uol.compass.hackathon.Banking.System.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class ClientDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos")
    private String cpf;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    @Past(message = "Data de nascimento deve ser no passado")
    @NotNull(message = "Data de nascimento é obrigatória")
    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate birthdate;

    // Construtores, getters e setters (ou use Lombok)
    public ClientDTO() {}

    public ClientDTO(String name, String cpf, String email, LocalDate birthdate) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthdate = birthdate;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getBirthdate() { return birthdate; }
    public void setBirthdate(LocalDate birthdate) { this.birthdate = birthdate; }
}