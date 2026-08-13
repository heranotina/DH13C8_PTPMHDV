package dh13c8.authservice.service;

import dh13c8.authservice.exception.InvalidCredentialsException;
import dh13c8.authservice.repository.UserRepository;
import dh13c8.authservice.security.JwtUtil;
import dh13c8.authservice.dto.LoginRequestDTO;
import dh13c8.authservice.dto.LoginResponseDTO;
import dh13c8.authservice.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new InvalidCredentialsException("Sai username hoac password"));
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword()))
        {
            throw new InvalidCredentialsException("Sai username hoac password");
        }
        String token = jwtUtil.generateToken(user.getUsername(),
                user.getRole());
        return new LoginResponseDTO(token, user.getUsername(),
                user.getRole());
    }
}
