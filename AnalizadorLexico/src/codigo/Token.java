/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author HP
 */
public class Token {

    private TokenConstant typeToken;
    private String lexemeToken;

    public Token(TokenConstant typeToken, String lexemeToken) {
        this.typeToken = typeToken;
        this.lexemeToken = lexemeToken;
    }

    public TokenConstant getTypeToken() {
        return typeToken;
    }

    public void setTypeToken(TokenConstant typeToken) {
        this.typeToken = typeToken;
    }

    public String getLexemeToken() {
        return lexemeToken;
    }

    public void setLexemeToken(String lexemeToken) {
        this.lexemeToken = lexemeToken;
    }

    @Override
    public String toString() {
        return "Token -> " + " type : " + typeToken + ", lexeme : " + lexemeToken +"\n";
    }
}
