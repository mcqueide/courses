package br.com.alura;

import br.com.alura.dto.MensagemErroDto;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

@Provider
public class ConstraintExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {

        return Response
                .status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity( MensagemErroDto.build(
                        e.getConstraintViolations()
                                .stream()
                                .map(constraintViolation -> constraintViolation.getMessage())
                                .collect(Collectors.toList())))
                .build();
    }
}