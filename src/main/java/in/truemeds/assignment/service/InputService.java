package in.truemeds.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.truemeds.assignment.beans.OutputBean;
import in.truemeds.assignment.entity.Input;
import in.truemeds.assignment.entity.Output;
import in.truemeds.assignment.repository.InputRepository;
import in.truemeds.assignment.repository.OutputRepository;

@Service
public class InputService {

    private static final Logger logger = LoggerFactory.getLogger(InputService.class);

    private InputRepository inputRepository;
    private OutputRepository outputRepository;

    public InputService(InputRepository inputRepository, OutputRepository outputRepository) {
        this.inputRepository = inputRepository;
        this.outputRepository = outputRepository;
    }

    public List<OutputBean> transformData() {
        long time = System.currentTimeMillis();
        List<Input> inputs = inputRepository.findAll();
        List<OutputBean> outputs = new ArrayList<>();
        for (Input input : inputs) {
            OutputBean output = transformDataUtil(input.getInput());
            outputs.add(output);
        }
        logger.info("Output processed. Time taken {} ms", System.currentTimeMillis() - time);
        return outputs;
    }

    @Transactional
    public ResponseEntity<Output> postTransformedData() {
        long time = System.currentTimeMillis();
        try {
            List<Input> inputs = inputRepository.findAll();
            for (Input input : inputs) {
                OutputBean output = transformDataUtil(input.getInput());
                outputRepository.save(new Output(output.getCount()));
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
        }
        logger.info("Output is updated in the database. Time taken {} ms", System.currentTimeMillis() - time);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public OutputBean transformDataUtil(String input) {
        UUID requestId = UUID.randomUUID();
        logger.info("Request id {} Input String {} ", requestId, input);
        int count = 0;
        input = input.replaceAll("\\s", "");
        StringBuilder str = new StringBuilder(input);
        while (true) {
            int tempCount = 0;
            for (int k = 0; k < str.length(); k++) {
                int i = k, j = k;
                tempCount = 0;
                while (j < str.length() - 1 && str.charAt(j) == str.charAt(j + 1)) {
                    j++;
                    tempCount++;
                }
                if (tempCount != 0) {
                    str.delete(i, j + 1);
                    break;
                }
            }
            if (tempCount == 0) {
                break;
            }
            count++;
        }
        logger.info("Request id {} Transformed String count is {} ", requestId, count);
        return new OutputBean(str.toString(), count);
    }

}
