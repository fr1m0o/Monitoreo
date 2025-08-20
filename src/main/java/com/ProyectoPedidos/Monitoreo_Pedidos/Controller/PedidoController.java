@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> obtenerPedidos() {
        try {
            return pedidoService.obtenerPedidos();
        } catch (Exception e) {
            e.printStackTrace(); // Muestra el stacktrace completo en la consola
            throw e; // para que el cliente reciba 500
        }
    }

    @PostMapping
    public Pedido guardarPedido(@RequestBody Pedido pedido) {
        if (pedido.getEstado() == null) pedido.setEstado(Pedido.EstadoPedido.EN_CAMINO);
        try {
            return pedidoService.guardarPedido(pedido);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/{id}")
    public Optional<Pedido> obtenerPedidoPorId(@PathVariable Long id) {
        try {
            return pedidoService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @PutMapping("/{id}")
    public Pedido actualizarPedido(@RequestBody Pedido pedido, @PathVariable Long id) {
        try {
            return pedidoService.actualizarPedidoPorId(pedido, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public String eliminarPedido(@PathVariable Long id) {
        try {
            boolean ok = pedidoService.borrarPedido(id);
            return ok ? "Pedido con ID " + id + " eliminado." : "Error al eliminar el pedido.";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Manejo global de excepciones dentro del mismo controller
    @ExceptionHandler(Exception.class)
    public String manejarExcepcion(Exception ex) {
        ex.printStackTrace(); // Aquí se ve todo el stacktrace en la consola del servidor
        return "Error interno del servidor: " + ex.getMessage();
    }
}
