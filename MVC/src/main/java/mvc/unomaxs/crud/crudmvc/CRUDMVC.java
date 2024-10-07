package mvc.unomaxs.crud.crudmvc;

import mvc.unomaxs.crud.controller.CtrlProducto;
import mvc.unomaxs.crud.model.ConsultasProducto;
import mvc.unomaxs.crud.model.Producto;
import mvc.unomaxs.crud.view.frmProducto;

public class CRUDMVC {

    public static void main(String[] args) {

        Producto mod = new Producto();
        ConsultasProducto modC = new ConsultasProducto();
        frmProducto frm = new frmProducto();

        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
}
