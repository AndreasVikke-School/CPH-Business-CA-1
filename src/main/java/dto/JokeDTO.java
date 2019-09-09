package dto;

import entities.Joke;
import entities.JokeType;
import java.util.Objects;

/**
 *
 * @author andreas
 */
public class JokeDTO {
    private long id;
    private String joke;
    private JokeType joketype;

    public JokeDTO(Joke joke) {
        this.id = joke.getId();
        this.joke = joke.getJoke();
        this.joketype = joke.getJokeType();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public JokeType getJoketype() {
        return joketype;
    }

    public void setJoketype(JokeType joketype) {
        this.joketype = joketype;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 17 * hash + Objects.hashCode(this.joke);
        hash = 17 * hash + Objects.hashCode(this.joketype);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JokeDTO other = (JokeDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.joke, other.joke)) {
            return false;
        }
        if (this.joketype != other.joketype) {
            return false;
        }
        return true;
    }
}
