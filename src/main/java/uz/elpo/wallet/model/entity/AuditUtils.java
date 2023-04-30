package uz.elpo.wallet.model.entity;

import org.springframework.security.core.context.SecurityContextHolder;

public class AuditUtils {

    private AuditUtils() {}

    public static AuthDetails getCurrentUser() {
        return (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
