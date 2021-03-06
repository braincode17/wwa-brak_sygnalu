package pl.allegro.braincode.messages.category;

import java.util.HashMap;
import java.util.Map;

public enum CategoryDto {
    CARS {
        @Override
        public Map<String, String> getProperties() {
            Map<String,String> props = new HashMap<>();
            props.put("używane","tak");
            props.put("rok produkcji","od 1990");
            props.put("rodzaj paliwa","benzyna");
            props.put("nadwozie","Sedan/Limuzyna");
            props.put("nadwozie","Sedan/Limuzyna");
            props.put("uszkodzony","nie");
            props.put("wyposażenie - pozostałe","alufelgi");
            return props;
        }

        @Override
        public String getName() {
            return "Samochody osobowe";
        }
    },
    PHONES {
        @Override
        public Map<String, String> getProperties() {
            Map<String,String> props = new HashMap<>();
            props.put("producent","Apple");
            props.put("stan","nowe");
            props.put("rodzaj oferty","kup teraz");
            props.put("pamiec","32GB");
            return props;
        }

        @Override
        public String getName() {
            return "Telefony";
        }
    },
    BICYCLES {
        @Override
        public Map<String, String> getProperties() {
            Map<String,String> props = new HashMap<>();
            props.put("stan","uzywane");
            props.put("rodzaj oferty","kup teraz");
            props.put("amortyzacja","brak");
            return props;
        }

        @Override
        public String getName() {
            return "Rowery";
        }
    },
    FURNITURE {
        @Override
        public Map<String, String> getProperties() {
            Map<String,String> props = new HashMap<>();
            props.put("rodzaj","stoliki i lawy");
            props.put("stan","nowe");
            props.put("rodzaj oferty","kup teraz");
            props.put("ksztalt blatu","kawdratowy");
            return props;
        }

        @Override
        public String getName() {
            return "Meble";
        }
    };

    public static final String CATEGORY = "Kategoria";

    public abstract Map<String,String> getProperties();
    public abstract String getName();

}
