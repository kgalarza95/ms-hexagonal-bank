package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.Account;
import ec.kgalarza.bank.dto.AccountInDTO;
import ec.kgalarza.bank.dto.AccountOutDTO;

public class AccountMapper {
    public static Account toDomain(AccountInDTO dto) {
        if (dto == null) return null;

        Account account = new Account();
        account.setAccountNumber(dto.getAccountNumber());
        account.setAccountType(dto.getAccountType());
        account.setOnlineBalance(dto.getOnlineBalance());
        account.setStatus(dto.isStatus());
        account.setCustomerId(dto.getCustomerId());

        return account;
    }

    public static AccountOutDTO toOutDTO(Account account) {
        if (account == null) return null;

        AccountOutDTO dto = new AccountOutDTO();
        dto.setId(account.getId());
        dto.setAccountNumber(account.getAccountNumber());
        dto.setAccountType(account.getAccountType());
        dto.setOnlineBalance(account.getOnlineBalance());
        dto.setStatus(account.isStatus());
        dto.setCustomerId(account.getCustomerId());

        return dto;
    }
}
