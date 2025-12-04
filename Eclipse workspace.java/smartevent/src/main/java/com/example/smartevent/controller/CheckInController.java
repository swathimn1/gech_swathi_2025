package com.example.smartevent.controller;

import com.example.smartevent.models.User;
import com.example.smartevent.repository.UserRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;


@RestController
@RequestMapping("/api/checkin")
@CrossOrigin(origins = "http://localhost:5173")
public class CheckInController {

    @Autowired
    private UserRepository userRepository;

    // ✅ Generate QR Code for a user
    @GetMapping(value = "/qrcode/{userId}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCode(@PathVariable Long userId) throws WriterException, IOException {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) return ResponseEntity.badRequest().build();

        User user = userOpt.get();
        String qrText = "USER_ID:" + user.getId() + ";USERNAME:" + user.getUsername() + ";EMAIL:" + user.getEmail();

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(qrText, BarcodeFormat.QR_CODE, 250, 250);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

        return ResponseEntity.ok(pngOutputStream.toByteArray());
    }

    // ✅ When scanned, confirm check-in
    @PostMapping("/confirm/{userId}")
    public ResponseEntity<String> confirmCheckIn(@PathVariable Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) return ResponseEntity.badRequest().body("❌ User not found!");
        return ResponseEntity.ok("✅ " + userOpt.get().getUsername() + " checked in successfully!");
    }
}
