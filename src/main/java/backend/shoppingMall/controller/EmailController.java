package backend.shoppingMall.controller;
import backend.shoppingMall.domain.EmailVerification;
import backend.shoppingMall.dto.EmailDto;
import backend.shoppingMall.service.MailService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class EmailController {
    private final MailService mailService;

    @PostMapping("/email-auth")
    public ResponseEntity<?> mailSend(@RequestBody EmailDto emailDto) throws MessagingException {
        System.out.println("email : " + emailDto.getEmail());
        mailService.sendMail(emailDto.getEmail());
        return ResponseEntity.ok("인증 코드 발송되었습니다.");
    }
    @PostMapping("/email-check")
    public ResponseEntity<?> verify(@RequestBody EmailDto emailDto) {
        Optional<EmailVerification> emailVerification = mailService.checkMail(emailDto.getEmail());
        if(emailVerification.isPresent() &&
                emailVerification.get().getAuthNum() == emailDto.getAuthNum()){
            return ResponseEntity.ok("인증완료 되었습니다.");
        }
        return ResponseEntity.status(400).body("실패하였습니다.");
    }
}
