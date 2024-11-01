package garment.project.controller;

import garment.project.entity.garment;
import garment.project.exception.ResourceNotFoundException;
import garment.project.service.GarmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garments")
public class GarmentController {

    private final GarmentService garmentService;

    @Autowired
    public GarmentController(GarmentService garmentService) {
        this.garmentService = garmentService;
    }

    @GetMapping
    public List<garment> getAllGarments() {
        return garmentService.findAllGarments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<garment> getGarmentById(@PathVariable Long id) {
        garment garment = garmentService.findGarmentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Garment not found with id " + id));
        return ResponseEntity.ok(garment);
    }

    @PostMapping
    public garment createGarment(@RequestBody garment garment) {
        return garmentService.saveGarment(garment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<garment> updateGarment(@PathVariable Long id, @RequestBody garment garmentDetails) {
        return ResponseEntity.ok(garmentService.updateGarment(id, garmentDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGarment(@PathVariable Long id) {
        garmentService.deleteGarment(id);
        return ResponseEntity.noContent().build();
    }
}
