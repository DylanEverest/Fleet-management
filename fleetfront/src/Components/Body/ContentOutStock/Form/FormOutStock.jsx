import Articles from "../../../../Services/DataForms/Articles/Articles";
import Magasins from "../../../../Services/DataForms/Magasins/Magasins";
import SubmitButton from "../../../Constants/Buttons/SubmitButtons";
import SelectForm from "../../../Constants/FormTools/Select";

export default function FormOutStock(props) 
{

    return(
        <div class="widget has-shadow">
            <div class="widget-header bordered no-actions d-flex align-items-center">
                <h4>Remplir</h4>
            </div>
            <div class="widget-body">
                <form class="form-horizontal">
                    
                    <div class="form-group row d-flex align-items-center mb-5">
                        <label class="col-lg-3 form-control-label">Quantite</label>
                        <div class="col-lg-9">
                            <input type="text" class="form-control"/>
                            <small>
                                En Kg.
                            </small>
                        </div>
                    </div>

                    <SelectForm label={"Articles"} option={Articles()}/>
                    
                    <SelectForm label={"Magasins"} option={Magasins()}/>           
                    
                    <div className="text-right">
                        <SubmitButton/>
                    </div>
                </form>
            </div>
        </div>
    );

}