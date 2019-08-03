package actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import exceptions.NotFoundException;
import interfaces.IBibliotecarioActions;
import model.ExemplarDeLivro;
import model.Livro;

public class BibliotecarioActions implements IBibliotecarioActions {

    @Override
    public void cadastrarExemplar(ExemplarDeLivro exemplar) throws FileNotFoundException, IOException {
        
    }

    @Override
    public void cadastrarLivro(Livro livro) throws FileNotFoundException, IOException {
        
    }

    @Override
    public void removerExemplar(ExemplarDeLivro exemplar) throws NotFoundException, IOException, ParseException {
        
    }

    @Override
    public void removerLivro(Livro livro) throws NotFoundException, IOException, ParseException {
        
    }

}