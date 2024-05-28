package cau.ict.btrack_week6.apiPayload.code;

import java.awt.desktop.UserSessionEvent;
import java.security.cert.CertPathValidatorException;

public interface BaseCode {
    public CertPathValidatorException.Reason getReason();

    public UserSessionEvent.Reason getReasonHttpStatus();
}
