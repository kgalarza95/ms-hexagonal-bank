package ec.kgalarza.bank.mapper;

import com.kgalarza.bank.entity.Account;
import ec.kgalarza.bank.model.entity.AccountEntity;

public class AccountRepoMapper {

    public static AccountEntity toEntity(Account dto) {
        if (dto == null) {
            return null;
        }
        AccountEntity entity = new AccountEntity();
        entity.setId(dto.getId());
        entity.setAccountNumber(dto.getAccountNumber());
        entity.setAccountType(dto.getAccountType());
        entity.setOnlineBalance(dto.getOnlineBalance());
        entity.setStatus(dto.isStatus());
        entity.setCustomerId(dto.getCustomerId());
        return entity;
    }

    public static Account toDTO(AccountEntity entity) {
        if (entity == null) {
            return null;
        }
        Account dto = new Account();
        dto.setId(entity.getId());
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setAccountType(entity.getAccountType());
        dto.setOnlineBalance(entity.getOnlineBalance());
        dto.setStatus(entity.isStatus());
        dto.setCustomerId(entity.getCustomerId());
        return dto;
    }
}
