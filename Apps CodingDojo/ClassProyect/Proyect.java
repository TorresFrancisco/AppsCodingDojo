public class Proyect {

        private String name;
        private String description;

        //Constructores
        
        public Proyect() { }
        
        public Proyect(String name) {
            this.name = name;
        }
        public Proyect(String name, String description) {
            this.name = name;
            this.description = description;
        }

        // Getters and Setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        //Metodo

        public String elevatorPitch() {
            return "Name: " + name + "\n" + 
            "Description: "  + description;
        }

}
