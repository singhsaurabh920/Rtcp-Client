package ro.star.seal.service.impl;

import ro.star.seal.dto.DocumentDto;
import ro.star.seal.dto.SessionDataDto;
import ro.star.seal.service.UpdateDocumentsPlugin;

import java.util.Map;

public class UmbrellaInsuranceOnUpdatePlugin implements UpdateDocumentsPlugin {

    @Override
    public Map<String, Object> beforeDocumentUpdated(SessionDataDto sessionDataDto, DocumentDto document) {
        return null;
    }

    @Override
    public void afterDocumentUpdated(SessionDataDto sessionDataDto, DocumentDto document) {

    }
}
