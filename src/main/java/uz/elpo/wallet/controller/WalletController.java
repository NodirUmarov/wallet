package uz.elpo.wallet.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.elpo.wallet.model.dto.WalletDto;
import uz.elpo.wallet.model.request.WalletCreateRequest;
import uz.elpo.wallet.service.WalletService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/wallet")
public class WalletController {

    private final WalletService walletService;

    @PostMapping
    public ResponseEntity<WalletDto> create(@RequestBody @Valid WalletCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(walletService.create(request));
    }
}
