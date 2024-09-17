package lab2.db.patient.lab2.db.patient;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    @GetMapping("/test")
    public String serviceTest(){
        return " Service works!";
    }

	@Autowired
	private PatientService patientService;

	@GetMapping("/patient")
	public List<Patient> getallPatient() {
		return patientService.getallPatient();
	}


	@GetMapping ("/patient/{id}")
	public Optional<Patient> getPatient(@PathVariable long id) {
		return patientService.getPatient(id);
	}

	@PostMapping("/patient")
	public String addPatient(@RequestBody Patient patient) {
		patientService.addPatient (patient);
		String response = "{\"Patient has been added successfully }";
		return response;
	}
	

	@PutMapping("/patient/{id}")
	public String updatePatient(@RequestBody Patient patient, @PathVariable String id) {
		patientService.updatePatient(id, patient);
		String response = "{\"Patient has been updated successfully.}";
		return response;
	}


	@DeleteMapping("/patient/{id}")
	public String deletePatient(@PathVariable Integer id) {
		patientService.deletePatient(id);
		String response = "{\"Patient has been deleted successfully.}";
		return response;
	}


}
