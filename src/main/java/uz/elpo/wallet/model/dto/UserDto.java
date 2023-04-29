package uz.elpo.wallet.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import uz.elpo.wallet.model.entity.User;

/**
 * A DTO for the {@link User} entity
 */
public record UserDto(Long id,
                      String firstName,
                      String lastName,
                      String patronymic,
                      String phoneNumber,
                      LocalDate dob,
                      String fullName,
                      String gender,
                      AuthDetailsDto authDetails) implements Serializable {
}