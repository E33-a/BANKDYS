package Bank.ListFInal;

import java.io.*;
public interface Files {
    public static void makeFile(String fileName){
        File file = new File(fileName);

        try {
            // Verificar si el archivo ya existe
            if (file.exists()) {
                System.out.println("\nEl archivo ya existe en la ruta: " + file.getAbsolutePath());
            } else {
                // Intentar crear el archivo
                if (file.createNewFile()) {
                    System.out.println("\nArchivo creado en la ruta: " + file.getAbsolutePath());
                } else {
                    System.out.println("\nNo se pudo crear el archivo.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String fileName, String content){
        File file = new File(fileName);

        try {
            //PrintWriter out = new PrintWriter(file); //si dejamos asi sobreescribe
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
            out.println(content);
            out.close();
            System.out.println("\nFile escrito");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }

    public static void readFileLine(String fileName){ //leer primer linea
        File file = new File(fileName); 

        try {
            BufferedReader in = new BufferedReader(new FileReader(file)); 
            String reading = in.readLine(); //primera linea

            in.close();
            System.out.println("\nPrimera linea de " + fileName + ":\n");
            System.out.println(reading);
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * @param fileName
     */
    public static void readFileAll(String fileName){ //leer todas las lineas
        File file = new File(fileName); 

        try {
            BufferedReader in = new BufferedReader(new FileReader(file)); 
            String reading = in.readLine(); //primera linea

            System.out.println("\nContenido de " + fileName + ":\n");
            while (reading != null){
                System.out.println(reading); //lee todas las lineas
                //reading = in.readLine();
            }

            in.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }  
    
    public static void deleteFile(String fileName){ 
        File file = new File(fileName); 

        if (file.exists()) {
            file.delete();
            System.out.println("\nArchivo" + fileName + " eliminado");
        } else {
            System.out.println("\nArchivo no existente");
        } 
    }   

    public static void deleteLinesFromFile(String fileName, int startLine, int endLine) {
        // Definir el archivo de entrada y el archivo temporal
        File inputFile = new File(fileName);    // Archivo original
        File tempFile = new File("tempFile.txt"); // Archivo temporal donde se almacenarán las líneas modificadas
    
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)); // FileReader para leer el archivo original
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) { // FileWriter para escribir en el archivo temporal
    
            String currentLine; // Variable para almacenar la línea actual leída
            int lineNumber = 1; // Contador de líneas
    
            // Leer cada línea del archivo original
            while ((currentLine = reader.readLine()) != null) {
                // Copiar la línea al archivo temporal si está fuera del rango especificado
                if (lineNumber < startLine || lineNumber > endLine) {
                    writer.write(currentLine + System.getProperty("line.separator")); // Escribir la línea en el archivo temporal
                }
                lineNumber++; // Incrementar el contador de líneas
            }
    
        } catch (IOException e) {
            e.printStackTrace(); // Manejar las excepciones de E/S (lectura y escritura de archivos)
        }
    
        // Renombrar el archivo temporal como el archivo original
        if (inputFile.delete()) { // Eliminar el archivo original
            if (tempFile.renameTo(inputFile)) { // Renombrar el archivo temporal como el archivo original
                // Imprimir mensaje de éxito
                System.out.println("\nSe eliminaron las líneas " + startLine + " a " + endLine + " de " + fileName);
            } else {
                // Imprimir mensaje si no se pudo renombrar el archivo temporal
                System.out.println("\nNo se pudo renombrar el archivo temporal.");
            }
        } else {
            // Imprimir mensaje si no se pudo eliminar el archivo original
            System.out.println("\nNo se pudo eliminar el archivo original.");
        }
    }
}
