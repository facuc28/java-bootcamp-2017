package com.bootcamp.java.Controller;

import com.bootcamp.java.Domain.State;
import junit.framework.TestCase;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import java.util.List;

/**
 * Created by facun on 03/02/2017.
 */
public class StateControllerTest extends TestCase {




    public void testGetStates() throws Exception {
       StateController stateController = Mockito.mock(StateController.class);
        ResponseEntity<List<State>> responseEntity= null;
        Mockito.when(stateController.getStates("USA")).thenReturn(responseEntity);
        assertEquals(responseEntity,stateController.getStates("USA"));

    }

}