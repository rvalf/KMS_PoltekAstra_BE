package com.example.kms_poltekastra_be.model.return_type.utilities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Menu {
    private String nama;
    private String link;
    private Integer parent;

    public Menu() {
    }

    public Menu(String nama, String link, Integer parent) {
        this.nama = nama;
        this.link = link;
        this.parent = parent;
    }

    @JsonProperty("nama")
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("parent")
    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }
}
