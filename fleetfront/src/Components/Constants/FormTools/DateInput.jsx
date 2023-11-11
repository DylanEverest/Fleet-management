export default function DateInput(props) {
    return (
        <div class="form-group row d-flex align-items-center mb-5">
            <label class="col-lg-3 form-control-label"> { props.label }</label>
            <div class="col-lg-9">
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="la la-calendar"></i>
                        </span>

                        <input type="text" class="form-control" id="daterange" placeholder="Select value"/>

                    </div>
                </div>
            </div>
        </div>
    );
}