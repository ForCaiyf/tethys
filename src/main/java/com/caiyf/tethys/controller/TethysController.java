package com.caiyf.tethys.controller;

import com.caiyf.tethys.message.api.MessageClient;
import com.caiyf.tethys.model.TethysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * tethys controller
 *
 * @author caiyf
 * @date 2020-04--11
 */
@RestController
@RequestMapping("/api/v1.0/tethys")
public class TethysController {

    @Autowired
    private MessageClient messageClient;

    @GetMapping("/send-message")
    public TethysResult<Boolean> sendMessage(@RequestParam("phone") String phone, @RequestParam("message") String message) {
        messageClient.sendShortMessage(phone, message);
        return TethysResult.getSuccessResult(Boolean.TRUE);
    }

}
