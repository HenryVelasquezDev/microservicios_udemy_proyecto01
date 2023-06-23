package com.auth.jwt.controller;

import com.auth.jwt.dto.AuthUserDto;
import com.auth.jwt.dto.NewUserDto;
import com.auth.jwt.dto.RequestDto;
import com.auth.jwt.dto.TokenDto;
import com.auth.jwt.entity.AuthUser;
import com.auth.jwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody AuthUserDto authUserDto){
        TokenDto tokenDto = authService.login( authUserDto );

        if ( authService == null ){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok( tokenDto );
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDto> validate(@RequestParam String token, @RequestBody RequestDto requestDto){
        TokenDto tokenDto = authService.validate( token, requestDto );

        if ( tokenDto == null ) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok( tokenDto );
    }

    @PostMapping("/create")
    public ResponseEntity<AuthUser> create( @RequestBody NewUserDto dto ){
        AuthUser authUser = authService.save( dto );

        if ( authUser == null ){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok( authUser );
    }
}
