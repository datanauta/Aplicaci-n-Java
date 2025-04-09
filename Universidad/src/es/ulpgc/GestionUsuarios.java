package es.ulpgc;

import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {
    private final List<Usuario> usuarios = new ArrayList<>();

    // Agregar usuario (sin cambios)
    public void agregarUSER(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Eliminar por nombre (¡clave! ahora recibe String)
    public boolean eliminarUSER(String nombre) {
        return usuarios.removeIf(usuario -> usuario.getNombre().equals(nombre));
    }

    // Obtener lista de usuarios (¡clave! método getter)
    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios); // Devuelve copia para encapsulación
    }
}