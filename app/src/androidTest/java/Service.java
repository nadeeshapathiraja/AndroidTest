import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.techswords.R;

public class Service extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }
}
