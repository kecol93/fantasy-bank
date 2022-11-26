package io.fantasy.bank.backend.rest.model.user;

import io.fantasy.bank.backend.rest.model.account.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String personalNumber;
    private List<AccountDTO> accounts;
}
