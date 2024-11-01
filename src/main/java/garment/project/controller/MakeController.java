package garment.project.controller;

import garment.project.entity.make;
import garment.project.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/makes")
public class MakeController {

    private final MakeService makeService;

    @Autowired
    public MakeController(MakeService makeService) {
        this.makeService = makeService;
    }

    @GetMapping
    public List<make> getAllMakes() {
        return makeService.findAllMakes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<make> getMakeById(@PathVariable Long id) {
        return makeService.findMakeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public make createMake(@RequestBody make make) {
        return makeService.saveMake(make);
    }

    @PutMapping("/{id}")
    public ResponseEntity<make> updateMake(@PathVariable Long id, @RequestBody make makeDetails) {
        return ResponseEntity.ok(makeService.updateMake(id, makeDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMake(@PathVariable Long id) {
        makeService.deleteMake(id);
        return ResponseEntity.noContent().build();
    }
}
