export default function SelectForm(props) {

    return (
        <div class="form-group row mb-5">
            <label class="col-lg-3 form-control-label">{props.label}</label>
            <div class="col-lg-9 select mb-3">
                <select name="account" class="custom-select form-control">
                    {props.option.map( (opt, index)=>(
                        <option key={index}> {opt} </option>    
                    ))}
                </select>
            </div>
        </div>
    );
    
}