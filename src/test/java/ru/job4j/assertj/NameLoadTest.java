package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkExceptionWhenDoesNotContainingAssignSign() {
        NameLoad nameLoad = new NameLoad();
        String data = "key:value";
        assertThatThrownBy(() -> nameLoad.parse(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(data);
    }

    @Test
    void checkExceptionWhenDoesNotHasKey() {
        NameLoad nameLoad = new NameLoad();
        String data = "=value";
        assertThatThrownBy(() -> nameLoad.parse(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(data);
    }

    @Test
    void checkExceptionWhenDoesNotHasValue() {
        NameLoad nameLoad = new NameLoad();
        String data = "key=";
        assertThatThrownBy(() -> nameLoad.parse(data))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(data);

    }
}