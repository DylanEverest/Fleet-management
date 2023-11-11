/* eslint-disable react/style-prop-object */

import DataStockState from "../../../Services/DataTables/StockStateServices";
import ContentHeader from "../../Constants/ContentHeader/ContentHeader";
import Sidebar from "../../Constants/Siderbar/Sidebar";
import Table from "../../Constants/Table/Table";


/* eslint-disable jsx-a11y/anchor-is-valid */
export default function ContentStockState(props) 
{
    const tableData= DataStockState();
    
    return(
        <div class="page-content d-flex align-items-stretch">

            <Sidebar/>

            <div class="content-inner">

                <div class="container-fluid">

                    <ContentHeader title="Etat de stock"/>               

                    <div class="row">

                        <div class="col-xl-12">

                            <Table columnHeaders={["Date début", "Date fin", "Article", "Magasin", "Quantité initiale", "Reste"]} tableData={tableData}/>                                
                        </div>

                    </div>

                </div>

            </div>

        </div>
    );

}