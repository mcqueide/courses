package com.fullcycle.admin.catalogo.application.genre.delete;

import com.fullcycle.admin.catalogo.domain.genre.GenreGateway;
import com.fullcycle.admin.catalogo.domain.genre.GenreId;

import java.util.Objects;

public class DefaultDeleteGenreUseCase extends DeleteGenreUseCase{

    private final GenreGateway genreGateway;

    public DefaultDeleteGenreUseCase(final GenreGateway genreGateway) {
        this.genreGateway = Objects.requireNonNull(genreGateway);
    }

    @Override
    public void execute(final String anId) {
        this.genreGateway.deleteById(GenreId.from(anId));
    }
}
