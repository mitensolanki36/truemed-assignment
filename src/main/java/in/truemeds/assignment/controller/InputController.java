package in.truemeds.assignment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.truemeds.assignment.beans.OutputBean;
import in.truemeds.assignment.entity.Output;
import in.truemeds.assignment.service.InputService;

@RestController
@RequestMapping("/api/v1/assignment")
public class InputController {

    private final InputService inputService;

    public InputController(InputService inputService) {
        this.inputService = inputService;
    }

    @GetMapping("/transform-data")
    public ResponseEntity<List<OutputBean>> transformData() {
        List<OutputBean> output = inputService.transformData();
        return new ResponseEntity<List<OutputBean>>(output, HttpStatus.OK);
    }

    @GetMapping("/transform-data/{input}")
    public ResponseEntity<OutputBean> postTransformedData(@PathVariable String input) {
        OutputBean output = inputService.transformDataUtil(input);
        return new ResponseEntity<OutputBean>(output, HttpStatus.OK);
    }

    @GetMapping("/post-transform-data")
    public ResponseEntity<Output> postTransformedData() {
        inputService.postTransformedData();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}