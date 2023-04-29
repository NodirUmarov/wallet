package uz.elpo.wallet.model.response;

import lombok.Builder;

@Builder
public record TokenResponse(String accessToken, String refreshToken) {
}