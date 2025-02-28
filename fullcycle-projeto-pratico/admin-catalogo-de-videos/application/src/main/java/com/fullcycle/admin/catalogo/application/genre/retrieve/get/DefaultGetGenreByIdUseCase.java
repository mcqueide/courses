package com.fullcycle.admin.catalogo.application.genre.retrieve.get;

import com.fullcycle.admin.catalogo.domain.Identifier;
import com.fullcycle.admin.catalogo.domain.exceptions.DomainException;
import com.fullcycle.admin.catalogo.domain.exceptions.NotFoundException;
import com.fullcycle.admin.catalogo.domain.genre.Genre;
import com.fullcycle.admin.catalogo.domain.genre.GenreGateway;
import com.fullcycle.admin.catalogo.domain.genre.GenreID;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultGetGenreByIdUseCase extends GetGenreByIdUseCase{

    private final GenreGateway genreGateway;

    public DefaultGetGenreByIdUseCase(final GenreGateway genreGateway) {
        this.genreGateway = Objects.requireNonNull(genreGateway);
    }

    @Override
    public GenreOutput execute(final String anId) {
        final var aGenreId = GenreID.from(anId);
        return this.genreGateway.findById(GenreID.from(anId))
                .map(GenreOutput::from)
                .orElseThrow(notFound(aGenreId));
    }

    private Supplier<DomainException> notFound(final Identifier anId) {
        return () -> NotFoundException.with(Genre.class, anId);
    }
}
