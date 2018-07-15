package com.kakaobank.assignment.searchimage.data.model.image;

import com.kakaobank.assignment.searchimage.data.model.Meta;

import java.util.List;

public class ImageResult {

    public Meta meta;
    public List<Document> documents;

    public ImageResult(Meta meta, List<Document> documents) {
        this.meta = meta;
        this.documents = documents;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
