package uz.elpo.wallet.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import uz.elpo.wallet.model.dto.WalletDto;
import uz.elpo.wallet.model.request.WalletCreateRequest;
import uz.elpo.wallet.service.WalletService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/wallet")
public class WalletController {

    private final WalletService walletService;

    @PostMapping
    public ResponseEntity<WalletDto> create(@RequestBody @Valid WalletCreateRequest request, Authentication authentication) {
        return ResponseEntity.status(HttpStatus.CREATED).body(walletService.create(request, authentication.getName()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletDto> getOne(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(walletService.getOne(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WalletDto> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(walletService.delete(id));
    }
}
