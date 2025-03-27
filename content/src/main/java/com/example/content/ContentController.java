package com.example.content;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentRepository contentRepository;

    public ContentController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    private List<Map<String, String>> mapList
            = List.of(
            Map.of("id", "1", "title", "AkademiaSpring.pl", "tag", "spring"),
            Map.of("id", "2", "title", "ArchitektIT.pl", "tag", "cloud"),
            Map.of("id", "3", "title", "Docker i Spring Cloud", "tag", "cloud")

    );

    @GetMapping
    public List<Content> getContent() {
        return contentRepository.findAll();
    }

    @GetMapping("/{tag}")
    public List<Content> getContentByTag(@PathVariable String tag) {
        return contentRepository.findByTagIgnoreCase(tag);
    }
}
