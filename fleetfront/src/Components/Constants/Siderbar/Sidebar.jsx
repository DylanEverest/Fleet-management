import { Link } from "react-router-dom";

export default function Sidebar()
{

    return (
        <div class="default-sidebar">
            <nav class="side-navbar box-scroll sidebar-scroll" tabindex="1" >
                <ul class="list-unstyled">
                    <li> <Link to="/prepareStockState"> <i class="la la-spinner"></i><span>Stock</span> </Link></li>
                    <li><Link to="/outStockState"> <i class="la la-spinner"></i><span>Sortie de stock</span> </Link> </li>
                </ul>
            </nav>
        </div>
    );
    
}