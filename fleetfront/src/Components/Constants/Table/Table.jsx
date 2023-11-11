
export default function Table(props) {

    return (
        <div className="widget has-shadow">
            <div className="widget-header bordered no-actions d-flex align-items-center">
                <h4>Border</h4>
            </div>
            <div className="widget-body">
                <div className="table-responsive">
                    <table className="table table-bordered mb-0">
                        <thead>
                            <tr>
                                {props.columnHeaders.map((header, index) => (
                                    <th key={index}>{header}</th>
                                ))}
                            </tr>
                        </thead>
                        <tbody>
                            {props.tableData.map((row) => (
                                <tr key={row.id}>
                                    {props.columnHeaders.map((header, index) => (
                                        <td key={index}>{row[header]}</td>
                                    ))}

                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}
