import ContentHeader from "../../Constants/ContentHeader/ContentHeader";
import Sidebar from "../../Constants/Siderbar/Sidebar";
import FormPrepareStock from "./Form/FormPrepareStock";

export default function ContentPrepareStock() 
{

    return(
        <div >
       <div class="page-content d-flex align-items-stretch">
            <Sidebar/>

            <div class="content-inner">
                <div class="container-fluid">
                    <ContentHeader title="Etat de stock"/>               
  
                    <div class="row flex-row">
                        <div class="col-12">
                            <FormPrepareStock/>
                        </div>
                    </div>
  
                </div>
            </div>
        </div>

        </div>
    );

}