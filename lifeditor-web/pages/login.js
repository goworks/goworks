import axios from 'axios';
import qs from 'qs';

class Login extends React.Component {
	constructor(props) {
        super(props);
        this.state = {
        	identifier: '',
        	password: ''
        };
        this.handleIdentifierChange = this.handleIdentifierChange.bind(this)
        this.handlePasswordChange = this.handlePasswordChange.bind(this)
        this.hanldeSubmit = this.hanldeSubmit.bind(this)
    }

    handleIdentifierChange(e) {
    	this.setState({
    		identifier: e.target.value
    	})
    }

    handlePasswordChange(e) {
		this.setState({
    		password: e.target.value
    	})
    }

	hanldeSubmit(e) {
		e.preventDefault()
		axios({
		    method: 'post',
		    url: `//api.lifeditor.com/login`,
		    headers: { 'content-type': 'application/x-www-form-urlencoded' },
		    withCredentials: true,
		    data: qs.stringify({
		        ...this.state
		    })
		}).then((resp) => {
			console.log(resp)
		})
	}

	render() {
		const state = this.state;
		return (
			<form onSubmit={this.hanldeSubmit}>
				<input name="identifier" placeholder="Input phone" value={state.identifier} onChange={this.handleIdentifierChange}/>
				<input name="password" placeholder="Input password" value={state.password} onChange={this.handlePasswordChange}/>
				<button>Submit</button>
			</form>
		);
	}
}

export default Login