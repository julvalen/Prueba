package cl.umag.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cl.ejemplos.listadecompras.modelo.ComprasDatabaseHelper;
import cl.ejemplos.listadecompras.modelo.Producto;

public class DetallesActivity extends AppCompatActivity {
    public Producto producto;
    public Intent intent;
    public DatabaseHelper helper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        intent=getIntent();
        String nombreProducto=(String) intent.getExtras().get("nombreProducto");

        producto= helper.getProducto(nombreProducto);



        TextView txtNombre=(TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(producto.getNombre());


        TextView txtCantidad=(TextView) findViewById(R.id.txtCantidad);
        txtCantidad.setText("Cantidad: "+producto.getCantidad()+" "+producto.getUnidad());


        TextView txtEstado=(TextView) findViewById(R.id.txtEstado);
        Button estado=(Button) findViewById(R.id.estado);

        if(producto.isEstado()==Producto.COMPRADO)
        {
            txtEstado.setText("Comprado");
            estado.setText("Marcar como Pendiente");
        }
        else
        {
            txtEstado.setText("Pendiente");
            estado.setText("Marcar como comprado");
        }
        estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                producto.setEstado(!producto.isEstado());

                String msg=helper.cambiarEstado(producto);
                Toast.makeText(DetallesActivity.this,msg,Toast.LENGTH_SHORT).show();

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}