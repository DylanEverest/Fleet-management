export default function ContentHeader(props) 
{

    return(
        <div class="row">
            <div class="page-header">
                <div class="d-flex align-items-center">
                    <h2 class="page-header-title">{props.title}</h2>
                    <div>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="db-default.html"><i class="ti ti-home"></i></a></li>
                            <li class="breadcrumb-item active">{props.title}</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    );

}