package ro.star.seal.service.impl;

import ro.star.seal.dto.DocumentDto;
import ro.star.seal.dto.SessionDataDto;
import ro.star.seal.service.SaveDocumentsPlugin;

import java.util.Map;

public class UmbrellaInsuranceOnSavePlugin implements SaveDocumentsPlugin {

    @Override
    public Map<String, Object> beforeDocumentCreated(SessionDataDto sessionDataDto, DocumentDto document) {
        return null;
    }

    @Override
    public void afterDocumentCreated(SessionDataDto sessionDataDto, DocumentDto document) {

    }
}
