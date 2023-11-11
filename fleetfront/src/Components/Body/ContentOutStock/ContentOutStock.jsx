import ContentHeader from "../../Constants/ContentHeader/ContentHeader";
import Sidebar from "../../Constants/Siderbar/Sidebar";
import FormOutStock from "./Form/FormOutStock";

export default function ContentOutStock() 
{

    return (
        <div class="page-content d-flex align-items-stretch">
            <Sidebar/>

            <div class="content-inner">
                <div class="container-fluid">
                    <ContentHeader title="Sortie de stock"/>               
  
                    <div class="row flex-row">
                        <div class="col-12">
                            <FormOutStock/>
                        </div>
                    </div>
  
                </div>
            </div>
        </div>
    );
}